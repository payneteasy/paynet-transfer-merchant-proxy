CREATE TABLE TransferData (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  invoice_id VARCHAR(64) UNIQUE,
  initiate_date TIMESTAMP NOT NULL DEFAULT current_timestamp(),
  check_date TIMESTAMP DEFAULT NULL,
  initiate_transfer_request VARCHAR(1024) NOT NULL,
  initiate_transfer_response VARCHAR(1024),
  check_transfer_request VARCHAR(1024),
  check_transfer_response VARCHAR(1024),
  is_initiate_error BOOLEAN,
  is_check_error BOOLEAN
);
