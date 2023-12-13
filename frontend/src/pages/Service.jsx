import ServiceDataCard from "../components/ServiceDataCard";
import ProviderDataCard from "../components/ProviderDataCard";

const ServiceData = 
    {
      title: "Dropdown de servicios: Mantenimiento del jardín",
      description: "Corte en figuras",
      image: "./images/download 4.jpg",
    };

  const ProviderData = {
      name: "Juan Jurado",
      contact: "+57312312312",
      image: "./images/download 3.jpg",
    };

export default function Service() {
  return (
    <div className="flex flex-wrap justify-around">
      
      <div className="border rounded m-[10px]">
        <h1>ServiceData</h1>
        <ServiceDataCard
          title={ServiceData.title}
          description={ServiceData.description}
          image={ServiceData.image}
        />
      </div>
      
      <div className="border rounded m-[10px]">
        <h2>ProviderData</h2>
        <ProviderDataCard
          name={ProviderData.name}
          contact={ProviderData.contact}
          image={ProviderData.image}
        />
      </div>
    </div>
  );
}
