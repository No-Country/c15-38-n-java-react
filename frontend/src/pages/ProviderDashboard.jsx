import { useSelector } from "react-redux";
import PropTypes from "prop-types";

const ServiceBox = ({ title, value, customClass }) => (
  <div
    className={`flex flex-col justify-between h-[128px] bg-gray-200 rounded p-4 ${customClass}`}
  >
    <span className="font-medium">{title}</span>
    <span className="text-[37px]">{value}</span>
  </div>
);

ServiceBox.propTypes = {
  title: PropTypes.string.isRequired,
  value: PropTypes.number.isRequired,
  customClass: PropTypes.string, // Optional custom class
};

const ProviderDashboard = () => {
  const userName = useSelector((state) => state.user.username);

  const services = [
    { name: "Servicio 1", id: 1 },
    { name: "Servicio 2", id: 2 },
    { name: "Servicio 3", id: 3 },
  ];

  return (
    <section className="mt-[150px] lg:max-w-[59rem] px-4 md:px-10 lg:px-0 xl:max-w-[80rem] 2xl:max-w-[90rem] mx-auto mb-16">
      <h1 className="text-lg font-medium">Bienvenido {userName}</h1>

      <div className="grid grid-cols-1 gap-8 mt-8 lg:grid-cols-2">
        <ServiceBox
          title="Servicios en total"
          value={1}
          customClass="mi-estilo-personalizado"
        />
        <ServiceBox
          title="Servicios activos"
          value={1}
          customClass="mi-estilo-personalizado"
        />
      </div>

      <div className="flex flex-col h-full p-4 mt-8 bg-gray-200 rounded">
        <h2 className="font-medium">Servicios listados</h2>
        <div className="h-[1px] rounded bg-black w-full"></div>

        {services.map((service) => (
          <div
            key={service.id}
            className="flex justify-between mt-8"
          >
            <p>{service.name}</p>
            <div className="flex gap-4">
              <button>
                <img
                  src="/images/updateIcon.svg"
                  alt="update button"
                />
              </button>
              <button>
                <img
                  src="/images/delete.svg"
                  alt="update button"
                />
              </button>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
};

export default ProviderDashboard;
