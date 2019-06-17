using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Orders.Models;
using Orders.Services;

namespace Orders.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrdersController : ControllerBase
    {
        private IOrdersService OrdersService;

        public OrdersController(IOrdersService ordersService)
        {
            OrdersService = ordersService;
        }

        [HttpGet]
        public ActionResult<ICollection<Order>> GetOrders()
        {
            return OrdersService.GetOrders().ToList();
        }

        [HttpPost]
        public ActionResult<Order> AddOrder([FromBody] Order order)
        {
            return OrdersService.AddOrder(order);
        }

        [HttpDelete("{id}")]
        public void DeleteOrder([FromRoute] int id)
        {
            OrdersService.DeleteOrder(id);
        }

        [HttpPut]
        public ActionResult<Order> UpdateOrder([FromBody] Order order)
        {
            Order UpdatedOrder = OrdersService.UpdateOrder(order);
            return UpdatedOrder;
        }

    }
}