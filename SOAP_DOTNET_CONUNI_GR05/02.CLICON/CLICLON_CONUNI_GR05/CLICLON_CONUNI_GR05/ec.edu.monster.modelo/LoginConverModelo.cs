using CLICLON_CONUNI_GR05.ConversionServiceReference;
using CLICLON_CONUNI_GR05.LoginServiceReference;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLICLON_CONUNI_GR05.ec.edu.monster.modelo
{
    public class LoginConverModelo
    {
        private readonly LoginServicioClient loginClient;
        private readonly ConversionUnidadesServicioClient conversionClient;

        public LoginConverModelo()
        {
            loginClient = new LoginServicioClient();
            conversionClient = new ConversionUnidadesServicioClient();
        }

        public bool Autenticar(string user, string password)
        {
            return loginClient.Login(user, password);
        }

        public double PulgadasACentimetros(double pulgadas)
        {
            return conversionClient.PulgadasACentimetros(pulgadas);
        }

        public double CentimetrosAPulgadas(double centimetros)
        {
            return conversionClient.CentimetrosAPulgadas(centimetros);
        }
    }
}
