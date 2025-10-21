using CLIESC_CONUNI_GR05.ConversionServiceReference;
using CLIESC_CONUNI_GR05.LoginServiceReference;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR05.ec.edu.monster.modelo
{
    public class ServiceManager
    {
        private readonly LoginServicioClient _loginService;
        private readonly ConversionUnidadesServicioClient _conversionService;

        public ServiceManager()
        {
            _loginService = new LoginServicioClient();
            _conversionService = new ConversionUnidadesServicioClient(); 
        }

        public bool Autenticar(string user, string password)
        {
            return _loginService.Login(user, password);
        }

        public double PulgadasACentimetros(double pulgadas)
        {
            return _conversionService.PulgadasACentimetros(pulgadas);
        }

        public double CentimetrosAPulgadas(double centimetros)
        {
            return _conversionService.CentimetrosAPulgadas(centimetros);
        }



    }
}
