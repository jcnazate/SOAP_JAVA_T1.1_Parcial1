using CONUNI_GR05.ec.edu.monster.modelo;
using CONUNI_GR05.ec.edu.monster.servicio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CONUNI_GR05.ec.edu.monster.controlador
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
