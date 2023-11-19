package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.BannerService;
import com.example.gadgetariumb7.dto.request.BannerRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banners")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Banner API")
public class BannerController {
    private final BannerService bannerService;

    @Operation(summary = "This method for save banners", description = "BannerRequest have array of images url and every image url is Banner")
    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public SimpleResponse save(@RequestBody BannerRequest bannerRequest) {
        return bannerService.addBanner(bannerRequest);
    }

    @Operation(summary = "Get all banners")
    @GetMapping
    public List<String> getAll() {
        return bannerService.getAll();
    }

}
