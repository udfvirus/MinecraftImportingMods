/*
 * Copyright 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.javavirys.minecraftmod.di

import com.javavirys.minecraftmod.data.repository.AssetModRepository
import com.javavirys.minecraftmod.data.repository.DatabaseModRepository
import com.javavirys.minecraftmod.data.repository.FileSystemImportModRepository
import com.javavirys.minecraftmod.domain.repository.ImportModRepository
import com.javavirys.minecraftmod.domain.repository.ModRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ASSET_QUALIFIER = "asset"

const val DATABASE_QUALIFIER = "local"

val repositoryModule = module {

    single<ModRepository>(named(ASSET_QUALIFIER)) { AssetModRepository(get()) }

    single<ModRepository>(named(DATABASE_QUALIFIER)) { DatabaseModRepository(get(), get()) }

    single<ImportModRepository> { FileSystemImportModRepository(get()) }
}