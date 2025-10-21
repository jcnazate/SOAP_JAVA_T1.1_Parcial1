using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace CONUNI_GR05.ec.edu.monster.servicio
{
    [ServiceContract]
    public interface IConversionUnidadesServicio
    {
        [OperationContract]
        double PulgadasACentimetros(double pulgadas);

        [OperationContract]
        double CentimetrosAPulgadas(double centimetros);
    }
}
