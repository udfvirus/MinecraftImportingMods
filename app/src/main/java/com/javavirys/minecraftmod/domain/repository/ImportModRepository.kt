package com.javavirys.minecraftmod.domain.repository

import com.javavirys.minecraftmod.core.entity.Mod

interface ImportModRepository {

    suspend fun importMod(item: Mod)

    suspend fun isImportedMod(item: Mod): Boolean
}