import express, { Express, Request, Response } from 'express';
import cors from 'cors';
import dotenv from 'dotenv';
import router from './routes/users';

dotenv.config();

const app: Express = express();
const port = process.env.PORT || 3000;

//middleware
app.use(cors());
app.use(express.json());

//Rutas
//Users
app.use('/api/users', router)

//Pruebas
app.get('/', (req: Request, res: Response) => {
  res.json(
    {
        message: 'Bienvenido a mi API REST con Node.js',
        version: '1.0.0',
    });
});

// Manejo de errores para rutas no encontradas
app.use((req: Request, res: Response) => {
  res.status(404).json({ 
    error: 'Ruta no encontrada' 
    });
});

// Iniciar el servidor
app.listen(port, () => {
  console.log(`Servidor ejecutandose en http://localhost:${port}`);

});