/*
 *
 *  Copyright 2017 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.metacat.common.server.connectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netflix.metacat.common.MetacatRequestContext;
import com.netflix.metacat.common.QualifiedName;
import com.netflix.metacat.common.dto.GetPartitionsRequestDto;
import com.netflix.metacat.common.dto.Pageable;
import com.netflix.metacat.common.dto.PartitionDto;
import com.netflix.metacat.common.dto.PartitionsSaveRequestDto;
import com.netflix.metacat.common.dto.PartitionsSaveResponseDto;
import com.netflix.metacat.common.dto.Sort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * Interfaces for manipulating partition information for this connector.
 *
 * @author tgianos
 * @since 0.1.51
 */
public interface ConnectorPartitionService extends ConnectorBaseService<PartitionDto> {
    /**
     * Gets the Partitions based on a filter expression for the specified table.
     *
     * @param requestContext    The Metacat request context
     * @param table             table handle to get partition for
     * @param partitionsRequest The metadata for what kind of partitions to get from the table
     * @param sort              sort by and order
     * @param pageable          pagination info
     * @return filtered list of partitions
     */
    default List<PartitionDto> getPartitions(
        @Nonnull final MetacatRequestContext requestContext,
        @Nonnull final QualifiedName table,
        @Nonnull final GetPartitionsRequestDto partitionsRequest,
        @Nullable final Sort sort,
        @Nullable final Pageable pageable
    ) {
        throw new UnsupportedOperationException("Not implemented for this connector");
    }

    /**
     * Add/Update/delete partitions for a table.
     *
     * @param requestContext        The Metacat request context
     * @param table                 table handle to get partition for
     * @param partitionsSaveRequest Partitions to save, alter or delete
     * @return added/updated list of partition names
     */
    default PartitionsSaveResponseDto savePartitions(
        @Nonnull final MetacatRequestContext requestContext,
        @Nonnull final QualifiedName table,
        @Nonnull final PartitionsSaveRequestDto partitionsSaveRequest
    ) {
        throw new UnsupportedOperationException("Not implemented for this connector");
    }

    /**
     * Delete partitions for a table.
     *
     * @param requestContext The Metacat request context
     * @param partitions     list of partition to delete
     */
    default void deletePartitions(
        @Nonnull final MetacatRequestContext requestContext,
        @Nonnull final List<QualifiedName> partitions
    ) {
        throw new UnsupportedOperationException("Not implemented for this connector");
    }

    /**
     * Number of partitions for the given table.
     *
     * @param requestContext The Metacat request context
     * @param table          table handle
     * @return Number of partitions
     */
    default int getPartitionCount(
        @Nonnull final MetacatRequestContext requestContext,
        @Nonnull final QualifiedName table
    ) {
        throw new UnsupportedOperationException("Not implemented for this connector");
    }

    /**
     * Returns all the partition names referring to the given <code>uris</code>.
     *
     * @param requestContext The Metacat request context
     * @param uris           locations
     * @param prefixSearch   if true, we look for tables whose location starts with the given <code>uri</code>
     * @return map of uri to list of partition names
     */
    default Map<String, List<QualifiedName>> getPartitionNames(
        @Nonnull final MetacatRequestContext requestContext,
        @Nonnull final List<String> uris,
        final boolean prefixSearch
    ) {
        return Maps.newHashMap();
    }

    /**
     * Gets the partition names/keys based on a filter expression for the specified table.
     *
     * @param requestContext    The Metacat request context
     * @param table             table handle to get partition for
     * @param partitionsRequest The metadata for what kind of partitions to get from the table
     * @param sort              sort by and order
     * @param pageable          pagination info
     * @return filtered list of partition names
     */
    default List<String> getPartitionKeys(
        @Nonnull final MetacatRequestContext requestContext,
        @Nonnull final QualifiedName table,
        @Nonnull final GetPartitionsRequestDto partitionsRequest,
        @Nullable final Sort sort,
        @Nullable final Pageable pageable
    ) {
        return Lists.newArrayList();
    }

    /**
     * Gets the partition uris based on a filter expression for the specified table.
     *
     * @param requestContext    The Metacat request context
     * @param table             table handle to get partition for
     * @param partitionsRequest The metadata for what kind of partitions to get from the table
     * @param sort              sort by and order
     * @param pageable          pagination info
     * @return filtered list of partition uris
     */
    default List<String> getPartitionUris(
        @Nonnull final MetacatRequestContext requestContext,
        @Nonnull final QualifiedName table,
        @Nonnull final GetPartitionsRequestDto partitionsRequest,
        @Nullable final Sort sort,
        @Nullable final Pageable pageable
    ) {
        return Lists.newArrayList();
    }
}