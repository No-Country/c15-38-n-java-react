import ServiceCard from "../components/ServiceCardComponent/ServiceCard";

const GardeningServicesData = [
  {
    title: "Ejemplo",
    image: "./images/download 1.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/download 2.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/download 3.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/download 4.jpg",
  },
];

export default function GardeningServices() {
  return (
    <section>
      <h1 className="text-xl font-semibold">Mantenimiento del jardín</h1>

      <div className="mt-4">
        <div className="relative items-center w-full mt-8">
          <div className="grid w-full gap-12 lg:grid-cols-3 md:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-6">
            {GardeningServicesData.map((project, index) => (
              <ServiceCard
                key={index}
                title={project.title}
                image={project.image}
                additionalContent={<p>Additional content for Home Cleaning</p>}
              />
            ))}
          </div>
        </div>
      </div>
    </section>
  );
}
