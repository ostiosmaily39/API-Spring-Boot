"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const userCrontroller_1 = require("../controllers/userCrontroller");
const router = (0, express_1.Router)();
router.get('/', userCrontroller_1.getAllUsers);
router.get('/:id', userCrontroller_1.getUserById);
router.post('/', userCrontroller_1.createUser);
router.put('/:id', userCrontroller_1.updateUser);
router.delete('/:id', userCrontroller_1.deleteUser);
exports.default = router;
//# sourceMappingURL=users.js.map