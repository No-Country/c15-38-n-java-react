import PropTypes from "prop-types";

const ServiceDataCard = ({ title, description, image }) => (
  <div className="w-full flex flex-col items-center">

    <div className="flex justify-between">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        {title}
      </p>
    </div>

    <div className="w-full flex justify-start">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        Descripción: {description}
      </p>
    </div>

    <div className="flex wrap">
      <img
        className="rounded-lg object-cover w-80 h-80 mx-[10px] my-[5px]"
        src={image}
        alt={title}
      />
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
  image: PropTypes.string.isRequired,
};

export default ServiceDataCard;