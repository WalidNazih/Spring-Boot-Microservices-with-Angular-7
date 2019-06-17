using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Orders.Models
{
    public class Order
    {
        public int OrderID { get; set; }
        public int ClientID { get; set; }
        public int OrderLineID { get; set; }
        public virtual ICollection<OrderLine> OrderLines { get; set; }
    }
}
