import axios from "axios"
import { API_HOST_URL, GET, PATH_GET_PAGE, PATH_PROFILE, PATH_REGISTER, POST, TOKEN } from "../shared/AppConstant";

export const callApi = (_type, _url, _params, _headers, _data) => {

    return axios({
        method: _type,
        url: _url,
        params: _params,
        headers: _headers,
        data: _data
    })
        .then((response) => {
            return response
        })
        .catch((error) => {
            return error
        })
}

export const tokenApi = (data) => {
    return callApi(POST, API_HOST_URL + TOKEN, "", "", { username: data.username, password: data.password })
}
export const profileApi = (data) => {
    let headers = {
        Authorization: `Bearer ${data}`
    }
    return callApi(GET, API_HOST_URL + PATH_PROFILE, "", headers, {})
}

export const signupApi = (data) => {
    return callApi(POST, API_HOST_URL + PATH_REGISTER, "", "", data)
}

export const getPageApi = ({ params, headers }) => {
    return callApi(GET, API_HOST_URL + PATH_GET_PAGE, params, headers, "")
}