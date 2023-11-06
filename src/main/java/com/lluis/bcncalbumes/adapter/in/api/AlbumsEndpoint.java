package com.lluis.bcncalbumes.adapter.in.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.bcncalbumes.adapter.in.api.exception.ErrorMessage;
import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.port.in.GetAlbums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Album Endpoint", description = "Album endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/albums")
public class AlbumsEndpoint {
    private final GetAlbums getAlbums;

    @Operation(
        summary = "Retrieve all the albums",
        description = "Retrieve all the albums"
    )
    @ApiResponse(
        responseCode = "200",
        content = @Content(array = @ArraySchema(
            schema = @Schema(implementation = AlbumResponse.class)),
            mediaType = "application/json")
    )
    @ApiResponse(
        responseCode = "500",
        content = @Content(
            schema = @Schema(implementation = ErrorMessage.class),
            mediaType = "application/json")
    )
    @GetMapping
    List<AlbumResponse> getAllAlbums() throws ValidationException {
        return getAlbums.getAllAlbums().stream()
            .map(AlbumResponse::of)
            .toList();
    }
}
