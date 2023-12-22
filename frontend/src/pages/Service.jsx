import ServiceDataCard from "../components/ServiceDataCard";
import ProviderDataCard from "../components/ProviderDataCard";

const ServiceData = {
      title: "Dropdown de servicios: 1 Mantenimiento del jardín",
      description: "Corte en figuras",
      precio: "20 dolares",
      image: "./images/download 4.jpg",
    }

  const ProviderData = {
      name: "Juan Jurado",
      contact: "+57312312312",
      image: "./images/download 3.jpg",
      email: "provedor@example.com"
    };

    

export default function Service() {

  return (
    <section className="mt-[150px] lg:max-w-[59rem] px-4 md:px-10 lg:px-0 xl:max-w-[80rem] 2xl:max-w-[90rem] mx-auto mb-16">

      <div className="w-full border rounded m-[10px]">
        <h2>ProviderData</h2>
        <ProviderDataCard
          name={ProviderData.name}
          contact={ProviderData.contact}
          email={ProviderData.email}
          image={ProviderData.image}
        />
      </div>

      <div className="w-full border rounded m-[10px]">
        <h1>ServiceData</h1>
        <ServiceDataCard
          title={ServiceData.title}
          description={ServiceData.description}
          precio={ServiceData.precio}
          image={ServiceData.image}
        />
      </div>

    </section>
  );
}
