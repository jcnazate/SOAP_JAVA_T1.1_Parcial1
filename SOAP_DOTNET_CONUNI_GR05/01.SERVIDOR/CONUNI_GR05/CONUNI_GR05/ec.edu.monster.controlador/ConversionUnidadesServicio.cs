using CONUNI_GR05.ec.edu.monster.modelo;
using CONUNI_GR05.ec.edu.monster.servicio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CONUNI_GR05.ec.edu.monster.controlador
{
    public class ConversionUnidadesServicio : IConversionUnidadesServicio
    {
        private readonly ConversionUnidadesModelo conUniModelo;

        public ConversionUnidadesServicio()
        {
            conUniModelo = new ConversionUnidadesModelo();
        }

        public double PulgadasACentimetros(double pulgadas)
        {
            return conUniModelo.PulgadasACentimetros(pulgadas);
        }

        public double CentimetrosAPulgadas(double centimetros)
        {
            return conUniModelo.CentimetrosAPulgadas(centimetros);
        }
    }
}
