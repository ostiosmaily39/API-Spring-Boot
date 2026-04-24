"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.deleteUser = exports.updateUser = exports.createUser = exports.getUserById = exports.getAllUsers = void 0;
const User_1 = require("../models/User");
//GET: Obtener todos los usuarios
const getAllUsers = (req, res) => {
    res.json({
        success: true,
        data: exports.getAllUsers,
        total: User_1.users.length
    });
};
exports.getAllUsers = getAllUsers;
//GET: Obtener un usuario por ID
const getUserById = (req, res) => {
    const { id } = req.params;
    const user = User_1.users.find(u => u.id === parseInt(id));
    if (!user) {
        res.status(404).json({
            success: false,
            error: 'Usuario con ID ${id} no encontrado'
        });
        return;
    }
    res.json({
        success: true,
        data: user
    });
};
exports.getUserById = getUserById;
//POST: Crear un nuevo usuario
const createUser = (req, res) => {
    const { name, email, age } = req.body;
    //Validaciones
    if (!name || !email || !age) {
        res.status(400).json({
            success: false,
            error: 'Los campos name, email, age son obligatorios'
        });
        return;
    }
    const newUser = {
        id: User_1.users.length > 0 ? Math.max(...User_1.users.map(u => u.id)) + 1 : 1,
        name,
        email,
        age
    };
    User_1.users.push(newUser);
    res.status(201).json({
        success: true,
        message: 'Usuario creado exitosamente',
        data: newUser
    });
};
exports.createUser = createUser;
//PUT: Actualizar un usuario
const updateUser = (req, res) => {
    const { id } = req.params;
    const { name, email, age } = req.body;
    const user = User_1.users.find(u => u.id === parseInt(id));
    if (!user) {
        res.status(404).json({
            success: false,
            error: `Usuario con ID ${id} no encontrado`
        });
        return;
    }
    if (name)
        user.name = name;
    if (email)
        user.email = email;
    if (age)
        user.age = age;
    res.json({
        success: true,
        message: 'Usuario actualizado exitosamente',
        data: user
    });
};
exports.updateUser = updateUser;
//DELETE: Eliminar usuario
const deleteUser = (req, res) => {
    const { id } = req.params;
    const Index = User_1.users.findIndex(u => u.id === parseInt(id));
    if (Index === -1) {
        res.status(404).json({
            success: false,
            error: `Usuario con ID ${id} no encontrado`
        });
        return;
    }
    const deleteUser = User_1.users.splice(Index, 1);
    res.json({
        success: true,
        message: 'Usuario eliminado exitosamente',
        data: deleteUser[0]
    });
};
exports.deleteUser = deleteUser;
//# sourceMappingURL=userCrontroller.js.map