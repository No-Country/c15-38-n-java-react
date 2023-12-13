import PropTypes from "prop-types";

const ServiceDataCard = ({ title, description, image }) => (
  <div className="w-full">

    <div className="flex justify-between">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color">
        {title}
      </p>
    </div>

    <img
      className="object-cover w-full rounded-lg h-60"
      src={image}
      alt={title}
    />

    <div className="flex justify-between">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color">
        {description}
      </p>
    </div>

  </div>
);

ServiceDataCard.propTypes = {
  title: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
};

export default ServiceDataCard;