/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.14.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

'use strict';

var models = require('./index');

/**
 * @class
 * Initializes a new instance of the Endpoints class.
 * @constructor
 * The URIs that are used to perform a retrieval of a public blob, queue or
 * table object.
 * @member {string} [blob] Gets the blob endpoint.
 * 
 * @member {string} [queue] Gets the queue endpoint.
 * 
 * @member {string} [table] Gets the table endpoint.
 * 
 * @member {object} [dummyEndPoint] Dummy EndPoint
 * 
 * @member {object} [fooPoint] Foo point
 * 
 * @member {object} [fooPoint.barPoint] Bar point
 * 
 * @member {object} [fooPoint.barPoint.recursivePoint] Recursive Endpoints
 * 
 */
function Endpoints() {
}

/**
 * Defines the metadata of Endpoints
 *
 * @returns {object} metadata of Endpoints
 *
 */
Endpoints.prototype.mapper = function () {
  return {
    required: false,
    serializedName: 'Endpoints',
    type: {
      name: 'Composite',
      className: 'Endpoints',
      modelProperties: {
        blob: {
          required: false,
          serializedName: 'blob',
          type: {
            name: 'String'
          }
        },
        queue: {
          required: false,
          serializedName: 'queue',
          type: {
            name: 'String'
          }
        },
        table: {
          required: false,
          serializedName: 'table',
          type: {
            name: 'String'
          }
        },
        dummyEndPoint: {
          required: false,
          serializedName: 'dummyEndPoint',
          type: {
            name: 'Composite',
            className: 'Endpoints'
          }
        },
        fooPoint: {
          required: false,
          serializedName: 'FooPoint',
          type: {
            name: 'Composite',
            className: 'Foo'
          }
        }
      }
    }
  };
};

module.exports = Endpoints;
