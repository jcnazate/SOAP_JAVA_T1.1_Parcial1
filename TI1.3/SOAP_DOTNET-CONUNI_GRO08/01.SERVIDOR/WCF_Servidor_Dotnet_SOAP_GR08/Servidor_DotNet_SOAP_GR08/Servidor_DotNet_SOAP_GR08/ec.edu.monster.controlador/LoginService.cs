using Servidor_DotNet_SOAP_GR08.ec.edu.monster.modelo;
using Servidor_DotNet_SOAP_GR08.ec.edu.monster.vista;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Servidor_DotNet_SOAP_GR08.ec.edu.monster.controlador
{
    public class LoginServicio : ILoginServicio
    {
        private readonly LoginModelo loginModelo;

        public LoginServicio()
        {
            loginModelo = new LoginModelo();
        }

        public bool Login(string user, string password)
        {
            return loginModelo.Login(user, password);
        }
    }
}
