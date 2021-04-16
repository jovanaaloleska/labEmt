import axios from '../custom-axios/axios';

const LibraryService = {

    fetchAuthors: () => {
        return axios.get("/authors");
    },


    fetchBooks: () =>
    {
        return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get("/categories");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },

    markBookAsTaken: (id) => {
        return axios.put(`/books/markAsTaken/${id}`);
    },

    addBook: (name, category, author, availableCopies ) => {
        return axios.post("/books/add", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },

    editBook: (id, name, category, author, availableCopies ) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }

}
export default LibraryService;