import PropTypes from "prop-types";

const ServiceDataCard = ({ name, contact, image }) => (
  <div className="w-full">

    <div className="flex justify-between">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color">
        {name}
      </p>
    </div>

    <img
      className="object-cover w-full rounded-lg h-60"
      src={image}
      alt={name}
    />

    <div className="flex justify-between">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color">
        {contact}
      </p>
    </div>

  </div>
);

ServiceDataCard.propTypes = {
  name: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
};

export default ServiceDataCard;