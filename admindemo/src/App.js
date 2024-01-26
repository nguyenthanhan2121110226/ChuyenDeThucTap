import React from "react";
import { Admin, Resource } from "react-admin";
import AdminPanel from "./component/AdminPanel";
import {
  listCategory,
  editCategory,
  createCategory,
} from "./component/Category";

import { listProduct, editProduct, CreateProduct } from "./component/Products";

import dataProvider from "./component/customDataProvider";
import { ListUser } from "./component/User";
import { ListOrder } from "./component/Order";

const App = () => (
  <Admin dashboard={AdminPanel} dataProvider={dataProvider}>
    <Resource
      name="categories"
      list={listCategory}
      edit={editCategory}
      create={createCategory}
    />
    <Resource
      name="products"
      list={listProduct}
      edit={editProduct}
      create={CreateProduct}
    />
    <Resource 
     name="users"
     list={ListUser} 
    />
    <Resource
     name="orders"
     list={ListOrder} 
      />
  </Admin>
);

export default App;
