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

    }
}