import ServiceCard from "../components/ServiceCardComponent/ServiceCard";

const HomeOrganizationData = [
  {
    title: "Ejemplo",
    image: "./images/1.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/2.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/3.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/4.jpg",
  },
];

export default function HomeOrganization() {
  return (
    <section>
      <h1 className="text-xl font-semibold">Organización del hogar</h1>

      <div className="mt-4">
        <div className="relative items-center w-full mt-8">
          <div className="grid w-full gap-12 lg:grid-cols-3 md:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-6">
            {HomeOrganizationData.map((project, index) => (
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
