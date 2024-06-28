import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/v1/vehicles";

export const listVehicles = () => {
    return axios.get(REST_API_BASE_URL);
}

export const createVehicle = (vehicle) => axios.post(REST_API_BASE_URL, vehicle);

export const getVehicle = (vehicleId) => axios.get(REST_API_BASE_URL + '/' + vehicleId);

export const updateVehicle = (vehicleId, vehicle) => axios.put(REST_API_BASE_URL + '/' + vehicleId,vehicle);

export const deleteVehicle = (vehicleId) => axios.delete(REST_API_BASE_URL + '/' + vehicleId);