using Orders.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Orders.Services
{
    public interface IOrdersService
    {
        ICollection<Order> GetOrders();
        Order AddOrder(Order order);
        void DeleteOrder(int OrderID);
        Order UpdateOrder(Order order);
    }
}
