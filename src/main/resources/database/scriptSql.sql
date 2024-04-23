CREATE TABLE agnes.customer(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address text,
    phone VARCHAR(20)
);

CREATE TABLE agnes.project_status (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50) NOT NULL
);

INSERT INTO agnes.project_status (status) VALUES ('PLANNING'), ('OPEN'), ('COMPLETED'), ('CANCELED');

CREATE TABLE agnes.project (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    customer_id INT NOT NULL,
    status_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES agnes.customer(id),
	FOREIGN KEY (status_id) REFERENCES agnes.project_status(id)
);
