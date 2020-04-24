window.onload = function() {
    // genus object contains all key:value combinations
    var genus = {
            '': ['', 'antelopehorns','Arkansas dozedaisy', 'blacksamson echinacea', 'broadleaf milkweed','buffalo clover', 'Bush_s purple coneflower',
                'butterfly milkweed','clasping milkweed',  'crimson clover', 'downy paintedcup','eastern purple coneflower',
                'Engelmann_s milkweed', 'entireleaf Indian paintbrush', 'fourleaf milkweed', 'golden tickseed', 'green antelopehorn',
                'green comet milkweed', 'green milkweed','hairy dozedaisy', 'Indian blanket', 'lanceleaf blanketflower', 'largeflower tickseed',
                'longhair phlox', 'Oklahoma phlox','pale purple coneflower','perfumeballs', 'Plains dozedaisy','plains milkweed','prairie Indian paintbrush',
                'red dome blanketflower', 'reversed clover', 'rough coneflower', 'sand milkweed', 'sanguine purple coneflower','showy milkweed',
                'sleepy silene', 'spider milkweed', 'star tickseed', 'stiff tickseed', 'strigose blacksamson', 'swamp milkweed', 'tall tickseed',
                'tapertip wakerobin','Topeka purple coneflower','whorled milkweed','white clover', 'Yarrow'],
            'Achillea':	['', 'Yarrow'],
            'Aphanostephus': ['', 'Arkansas dozedaisy', 'hairy dozedaisy', 'Plains dozedaisy'],
            'Asclepias': ['', 'antelopehorns', 'broadleaf milkweed', 'butterfly milkweed', 'clasping milkweed', 'Engelmann_s milkweed',
                'fourleaf milkweed', 'green antelopehorn', 'green comet milkweed', 'green milkweed', 'plains milkweed', 'sand milkweed',
                'showy milkweed', 'spider milkweed', 'swamp milkweed', 'whorled milkweed'],
            'Castilleja': ['', 'downy paintedcup', 'entireleaf Indian paintbrush', 'prairie Indian paintbrush'],
            'Coreopsis': ['', 'golden tickseed', 'largeflower tickseed', 'star tickseed', 'stiff tickseed', 'tall tickseed'],
            'Echinacea': ['', 'blacksamson echinacea', 'Bush_s purple coneflower', 'eastern purple coneflower', 'pale purple coneflower',
                'sanguine purple coneflower', 'strigose blacksamson', 'Topeka purple coneflower'],
            'Gaillardia': ['', 'Indian blanket', 'lanceleaf blanketflower', 'perfumeballs', 'red dome blanketflower'],
            'Phlox': ['', 'longhair phlox', 'Oklahoma phlox'],
            'Rudbeckia': ['', 'rough coneflower'],
            'Silene': ['', 'sleepy silene'],
            'Trifolium': ['', 'buffalo clover', 'crimson clover', 'reversed clover', 'white clover'],
            'Trillium':	['', 'tapertip wakerobin']
        },
        // references to the two drop-downs
        genus_select = document.querySelector('#genus'),
        common_select = document.querySelector('#common_name');

    // populate the genus drop-down
    // setOptions(genus_select, Object.keys(genus));
    // // populate the common name drop-down
    // setOptions(common_select, genus[prov_select.value]);

    // attach a change event listener to the genus drop-down
    genus_select.addEventListener('change', function() {
        // get the common names in the selected genus
        setOptions(common_select, genus[genus_select.value]);
    });
    // biome object contains all key:value combinations
    var biome = {
            "":  ['','Adair','Alfalfa','Atoka','Beaver','Beckham','Blaine','Bryan','Caddo','Canadian','Carter','Cherokee','Choctaw','Cimarron',
                'Cleveland','Coal','Comanche','Cotton','Craig','Creek','Custer','Delaware','Dewey','Ellis','Garfield','Garvin','Grady','Grant',
                'Greer','Harmon','Harper','Haskell','Hughes','Jackson','Jefferson','Johnston','Kay','Kingfisher','Kiowa','Latimer','Le Flore',
                'Lincoln','Logan','Love','McClain','McCurtain','McIntosh','Major','Marshall','Mayes','Murray','Muskogee','Noble','Nowata',
                'Okfuskee','Oklahoma','Okmulgee','Osage','Ottawa','Pawnee','Payne','Pittsburg','Pontotoc','Pottawatomie','Pushmataha','Roger Mills',
                'Rogers','Seminole','Sequoyah','Stephens','Texas','Tillman','Tulsa','Wagoner','Washington','Washita','Woods','Woodward'],
            '1':	['', 'Beaver',	'Cimarron',	'Texas'],
            '2':	['', 'Alfalfa',	'Ellis', 'Garfield', 'Grant', 'Harper', 'Kay', 'Major', 'Noble', 'Woods', 'Woodward'],
            '3':	['', 'Adair', 'Cherokee', 'Craig', 'Creek', 'Delaware', 'Hughes', 'Mayes', 'McIntosh', 'Muskogee', 'Nowata', 'Okfuskee',
                'Okmulgee',	'Osage', 'Ottawa', 'Pawnee', 'Rogers', 'Sequoyah', 'Tulsa',	'Wagoner', 'Washington'],
            '4':	['', 'Atoka', 'Bryan', 'Choctaw', 'Coal', 'Haskell', 'Latimer',	'Le Flore',	'McCurtain', 'Pittsburg', 'Pushmataha'],
            '5':	['', 'Carter', 'Garvin', 'Johnston', 'Love', 'Marshall', 'McClain',	'Murray', 'Pontotoc', 'Pottawatomie', 'Seminole'],
            '6':	['', 'Canadian', 'Cleveland', 'Kingfisher',	'Lincoln',	'Logan', 'Oklahoma', 'Payne'],
            '7':	['', 'Beckham',	'Blaine', 'Caddo', 'Comanche', 'Cotton', 'Custer', 'Dewey',	'Grady', 'Greer', 'Harmon',
                'Jackson', 'Jefferson',	'Kiowa', 'Roger Mills',	'Stephens',	'Tillman',	'Washita']
        },
        // references to the two drop-downs
        biome_select = document.querySelector('#biome'),
        county_select = document.querySelector('#county_auto');

    // populate the biome drop-down
    // setOptions(biome_select, Object.keys(biome));
    // // populate the county drop-down
    // setOptions(county_select, biome[biome_select.value]);

    // attach a change event listener to the biomes drop-down
    biome_select.addEventListener('change', function() {
        // get the counties in the selected biomes
        setOptions(county_select, biome[biome_select.value]);
    });

    function setOptions(dropDown, options) {
        // clear out any existing values
        dropDown.innerHTML = '';
        // insert the new options into the drop-down
        options.forEach(function(value) {
            dropDown.innerHTML += '<option name="' + value + '">' + value + '</option>';
        });
    }
}

$(document).ready(function(){
    var date_submission=$('input[name="date"]'); //input with name=date in submission form
    var start_date=$('input[name="start_date"]');
    var end_date=$('input[name="end_date"]');
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
        orientation: "top",
    };
    date_submission.datepicker(options);
    start_date.datepicker(options);
    end_date.datepicker(options);
})

