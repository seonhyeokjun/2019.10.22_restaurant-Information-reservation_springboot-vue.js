package kr.co.seonhyeokjun.eatgo.interfaces;

import com.sun.media.sound.DLSInstrument;
import kr.co.seonhyeokjun.eatgo.application.RegionService;
import kr.co.seonhyeokjun.eatgo.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> list(){
        List<Region> regions = regionService.getRegions();

        return regions;
    }
}
