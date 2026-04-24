export interface User {
  id: number;
  name: string;
  email: string;
  age: number;
}

//Base de datos (Coleccion) simulada
export const users: User[] = [
  { id: 1, name: 'Adara Lopez', email: 'adarlopezzzz@sena.edu.co', age: 18 },
  { id: 2, name: 'Emily Lacrontte', email: 'reinaEmily@sena.edu.co', age: 20 },
  { id: 3, name: 'Magnus Lacrontte', email: 'elhumilde@sena.edu.co', age: 27 }
]; 