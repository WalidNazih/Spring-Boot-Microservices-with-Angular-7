using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Orders.Models
{
    public class OrderLine
    {
        [Key]
        public int OrderLineID { get; set; }
        public int ProductID { get; set; }
        public int OrderID { get; set; }
        public virtual Order Order { get; set; }
    }
}
