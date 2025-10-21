using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace Servidor_DotNet_SOAP_GR08.ec.edu.monster.vista
{
    [ServiceContract]
    public interface ILoginServicio
    {
        [OperationContract]
        bool Login(string user, string password);
    }
}

