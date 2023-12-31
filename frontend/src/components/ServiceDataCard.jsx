import PropTypes from "prop-types";

const ServiceDataCard = ({ title, description, precio, image }) => (
  <div className="w-full flex flex-col items-center p-[20px]">
    <div className="flex justify-center w-full">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        {title}
      </p>
    </div>

    <div className="flex flex-col w-full">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        Descripción: {description}
      </p>
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        Precio: {precio}
      </p>
    </div>

    <div className="flex wrap">
      <img
        className="rounded-lg object-cover w-80 h-80 mx-[10px] my-[5px]"
        src={image}
        alt={title}
      />
    </div>
  </div>
);

ServiceDataCard.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  precio: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
};

export default ServiceDataCard;
