using ConversionServiceReference;
using LoginServiceReference;

namespace CLIWEB_CONUNI_GR05.Models
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

        public async Task<bool> AutenticarAsync(string user, string password)
        {
            return await loginClient.LoginAsync(user, password);
        }

        public async Task<double> PulgadasACentimetrosAsync(double pulgadas)
        {
            return await conversionClient.PulgadasACentimetrosAsync(pulgadas);
        }

        public async Task<double> CentimetrosAPulgadasAsync(double centimetros)
        {
            return await conversionClient.CentimetrosAPulgadasAsync(centimetros);
        }
    }
}
