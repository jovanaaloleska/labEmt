import React from 'react';
import {Link} from 'react-router-dom';

const booksTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name+" "+props.term.author.surname}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    DELETE
                </a>
            </td>
            <td className={"text-right"}>
                <a title={"Rent"} className={"btn btn-success"}
                   onClick={() => props.onMarkAsTaken(props.term.id)}>
                    RENT
                </a>
            </td>
            <td>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
            </td>
        </tr>
    )
}

export default booksTerm;