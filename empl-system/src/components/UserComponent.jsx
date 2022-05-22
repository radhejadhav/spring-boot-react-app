import React from 'react'
import { useParams } from 'react-router'

export default function () {

    const param = useParams()


  return (
    <div>hello {param.username}</div>
  )
}
