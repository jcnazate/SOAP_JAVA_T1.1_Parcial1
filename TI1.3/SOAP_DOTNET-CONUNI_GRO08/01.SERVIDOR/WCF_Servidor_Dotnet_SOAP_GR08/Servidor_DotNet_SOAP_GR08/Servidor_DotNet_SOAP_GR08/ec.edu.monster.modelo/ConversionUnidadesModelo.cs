using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Servidor_DotNet_SOAP_GR08.ec.edu.monster.modelo
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
        // Conversión de Celsius a Kelvin
        public double CelsiusAKelvin(double celsius)
        {
            return celsius + 273.15;
        }

        // Conversión de Kelvin a Celsius
        public double KelvinACelsius(double kelvin)
        {
            return kelvin - 273.15;
        }

        // Conversión de gramos a kilogramos
        public double GramosAKilogramos(double gramos)
        {
            return gramos / 1000.0;
        }

        // Conversión de kilogramos a gramos
        public double KilogramosAGramos(double kilogramos)
        {
            return kilogramos * 1000.0;
        }
    }
}
