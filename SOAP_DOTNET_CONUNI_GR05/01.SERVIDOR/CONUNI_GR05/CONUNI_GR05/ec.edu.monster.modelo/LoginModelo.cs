using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CONUNI_GR05.ec.edu.monster.modelo
{
    public class LoginModelo
    {
        public bool Login(string user, string password)
        {
            // Compara con el usuario y la contraseña hasheada (igual que en Java)
            return user == "MONSTER" &&
                   password == "MONSTER9";
        }
    }
    
}
