using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace CONUNI_GR05.ec.edu.monster.servicio
{
    [ServiceContract]
    public interface ILoginServicio
    {
        [OperationContract]
        bool Login(string user, string password);
    }
}
