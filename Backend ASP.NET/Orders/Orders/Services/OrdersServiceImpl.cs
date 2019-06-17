using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Orders.Models;

namespace Orders.Services
{
    public class OrdersServiceImpl : IOrdersService
    {

        private OrderDBContext OrderRepository;

        public OrdersServiceImpl(OrderDBContext OrderRepository)
        {
            this.OrderRepository = OrderRepository;
        }

        public Order AddOrder(Order order)
        {
            OrderRepository.Orders.Add(order);
            OrderRepository.SaveChanges();
            return order;
        }

        public void DeleteOrder(int OrderID)
        {
            Order order = OrderRepository.Orders.Where(Order => Order.OrderID == OrderID).First();
            OrderRepository.Orders.Remove(order);
            OrderRepository.SaveChanges();
        }

        public ICollection<Order> GetOrders()
        {
            return OrderRepository.Orders.ToList();
        }

        public Order UpdateOrder(Order order)
        {
            Order OrderUpdated = OrderRepository.Orders.Update(order).Entity;
            OrderRepository.SaveChanges();
            return OrderUpdated;
        }
    }
}
