import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/v1/rentals";

export const listRentals = async () => {
    try {
        const response = await axios.get(REST_API_BASE_URL);
        return response;
    } catch (error) {
        console.error(`Failed to list rentals: ${error.message}`);
        if (error.response) {
            console.error(`Response status: ${error.response.status}`);
            console.error(`Response data: ${JSON.stringify(error.response.data)}`);
        }
        throw error;
    }
};

export const createRental = (rental) => axios.post(REST_API_BASE_URL, rental);

export const getRental = (rentalId) => axios.get(REST_API_BASE_URL + '/' + rentalId);

export const updateRental = (rentalId, rental) => axios.put(REST_API_BASE_URL + '/' + rentalId, rental);

export const deleteRental = (rentalId) => axios.delete(REST_API_BASE_URL + '/' + rentalId);
