using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CONUNI_GR05.ec.edu.monster.modelo
{
    public class ConversionUnidadesModelo
    {
        public double PulgadasACentimetros(double pulgadas)
        {
            return pulgadas * 2.54;
        }

        public double CentimetrosAPulgadas(double centimetros)
        {
            return centimetros / 2.54;
        }
    }
}
