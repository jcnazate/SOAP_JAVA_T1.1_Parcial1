using Servidor_DotNet_SOAP_GR08.ec.edu.monster.modelo;
using Servidor_DotNet_SOAP_GR08.ec.edu.monster.service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Servidor_DotNet_SOAP_GR08.ec.edu.monster.controlador
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

        public double CelciusAKelvin(double celcius)
        {
            return conUniModelo.CelsiusAKelvin(celcius);
        }

        public double KelvinACelcius(double kelvin)
        {
            return conUniModelo.KelvinACelsius(kelvin);
        }

        public double GramosAKilogramos(double gramos)
        {
            return conUniModelo.GramosAKilogramos(gramos);
        }

        public double KilogramosAGramos(double kilogramos)
        {
            return conUniModelo.KilogramosAGramos(kilogramos);
        }
    }
}
