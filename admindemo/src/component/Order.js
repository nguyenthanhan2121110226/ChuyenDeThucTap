import { List, Datagrid, TextField } from "react-admin";

const dummyDataProvider = {
  getList: () => Promise.resolve({ data: [{ id: 1, address: "Dummy Address" }], total: 1 }),
};

export const ListOrder = (props) => (
  <List {...props} dataProvider={dummyDataProvider}>
    <Datagrid>
      <TextField source="id" />
      <TextField source="address" />
    </Datagrid>
  </List>
);
