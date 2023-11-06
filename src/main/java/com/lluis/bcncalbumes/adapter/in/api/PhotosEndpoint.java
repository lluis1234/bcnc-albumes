package com.lluis.bcncalbumes.adapter.in.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.bcncalbumes.adapter.in.api.exception.ErrorMessage;
import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;
import com.lluis.bcncalbumes.domain.port.in.GetPhotos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Photo Endpoint", description = "Photo endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/photos")
public class PhotosEndpoint {
    private final GetPhotos getPhotos;
    
    @Operation(
        summary = "Retrieve photo by its id",
        description = "Retrieve photo by its id"
    )
    @ApiResponse(
        responseCode = "200",
        content = @Content(
            schema = @Schema(implementation = PhotoResponse.class),
            mediaType = "application/json")
    )
    @ApiResponse(
        responseCode = "404",
        content = @Content(
            schema = @Schema(implementation = ErrorMessage.class),
            mediaType = "application/json")
    )
    @ApiResponse(
        responseCode = "500",
        content = @Content(
            schema = @Schema(implementation = ErrorMessage.class),
            mediaType = "application/json")
    )
    @GetMapping("/{id}")
    PhotoResponse getPhotoById(@PathVariable Long id) throws NoSuchElementException, ValidationException {
        return PhotoResponse.of(getPhotos.get(new PhotoId(id)));
    }

    @Operation(
        summary = "Retrieve photos from album",
        description = "Retrieve photos from album"
    )
    @ApiResponse(
        responseCode = "200",
        content = @Content(array = @ArraySchema(
            schema = @Schema(implementation = PhotoResponse.class)),
            mediaType = "application/json"))
    @ApiResponse(
        responseCode = "500",
        content = @Content(
            schema = @Schema(implementation = ErrorMessage.class),
            mediaType = "application/json")
    )
    @GetMapping
    List<PhotoResponse> getPhotosByAlbumId(@RequestParam Long albumId) throws ValidationException {
        return getPhotos.get(new AlbumId(albumId)).stream()
            .map(PhotoResponse::of)
            .toList();
    }
}
