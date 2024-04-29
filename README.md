# Welcome to Miydi Maps

Miydi Maps is an extensive repository dedicated to providing highly detailed socio-economic data, meticulously compiled down to individual census tracts and zip codes. This initiative is designed to streamline the utilization of geographic data across various advanced applications, including Artificial Intelligence, data analytics, urban planning, and more, by eliminating the complexities of data parsing.

<p align="center">
  <img src="/Miydi_Map_logo.png" alt="Miydi Maps Logo" width="400"/>
</p>

## 🌍 Data Granularity and Accessibility

Each dataset within Miydi Maps is structured to align with zip codes or census tracts, presenting a unique opportunity to access socio-economic data with unprecedented precision. This level of detail opens new avenues for localized research and development, offering insights that were previously challenging to obtain.

![Example of Tract Level Visualization](/_bin/images/qgis-bin_28gTTMkiHq.jpg)

# Miydi Maps - Open Street Data 

Welcome to the Open Street Data, a dedicated repository housing GeoJson formatted data derived from Open Street Maps (OSM) specifically for the United States, with plans to extend coverage to other countries shortly. 

## 🌐 About the Data

Each file within this collection represents a single layer and "type" of OSM data, allowing for a modular approach where users can select exactly what they need for their projects. Due to GitHub's size constraints, data may be segmented into smaller, zipped files to ensure accessibility without compromising detail.

### Data Compilation and Cleaning

The data was meticulously compiled using the OSM API, pulling data for individual US regions to circumvent API limitations. This regional data was then amalgamated into comprehensive GeoJSON files. A thorough cleaning process was undertaken to eliminate duplicates, ensuring the integrity and usability of the datasets.

![Each layer stored separately](/_bin/images/qgis-bin_sMGoSIVL9W.jpg)

### Handling Extraneous Data Points

It's important to note that the original OSM API data contains a large number of extraneous data points, many of which have NULL values. These have been preserved in the datasets as they may hold value for specific projects, despite their apparent redundancy. Their presence does not significantly affect the overall size of the datasets due to their null value nature.

## 📅 Data Timeliness

The datasets currently available were pulled in April 2024. Please be aware that this data will not receive updates. However, we are considering the incorporation of additional data sets in future releases to ensure the continued relevance and expansion of the Miydi Maps - Open Street Data edition.

# Using the Miydi Maps Connection Layers

Introducing the Miydi Maps Connection Layer, a versatile and powerful tool within the Miydi Maps - Open Street Data edition designed to seamlessly integrate various datasets with geospatial mapping. This layer serves as a comprehensive bridge, containing an array of state and government identifiers that are prevalent in a vast majority of public reports and datasets.

## 🌐 Key Features of the Connection Layers

The Connection Layer is your gateway to unlocking the full potential of geospatial data analysis. It is meticulously curated to include connectors for:

- **Census-Level Data:** Enabling detailed demographic and socio-economic analysis at the granular census tract level.
- **Administrative Divisions:** Incorporating identifiers for city, state, county, and divisional data, ensuring compatibility with a wide range of governmental datasets.
- **Ecological Zones:** Featuring connectors for ecological regions, including Levels 1, 2, and 3, facilitating environmental and ecological research.

## 🚀 How to Use the Connection Layers

Utilizing the Connection Layer is straightforward and efficient—simply join your dataset with the Connection Layer to map your data geospatially. This integration allows for the enrichment of your datasets with precise geographic identifiers, making it possible to overlay your data onto maps with high accuracy and relevance.

### Step-by-Step Integration:

1. **Prepare Your Dataset:** Ensure your dataset is structured and ready for integration, with clear identifiers and data points that you wish to analyze geospatially.
2. **Join with the Connection Layer:** Use common database tools or data analysis software to join your dataset with the Connection Layer, matching your data points with the appropriate geographic identifiers contained within the layer.
3. **Visualize and Analyze:** With your data now geospatially connected, you can visualize, analyze, and derive insights with enhanced geographic context and precision.

The Miydi Maps Connection Layer is an essential tool for researchers, analysts, urban planners, and anyone looking to leverage the power of geospatial data. By providing a straightforward method to connect disparate datasets to geographic locations, this layer opens up new avenues for data-driven decision-making and spatial analysis.


### Bell Curve Analysis and Weighted System

Our methodology revolves around the segmentation of data into seven distinct tiers, with a deliberate focus on outliers before delving into more common data points. This tiered analysis allows us to assign varying weights to different segments of the data, with the bulk of our attention—and weight—placed on the middle tiers, where the most common values reside.

#### Data Tier Segmentation

- **Tier 1 & 7 (Outliers):** We start our analysis at the extremes, examining the top and bottom 10% of the dataset. These outliers often reveal unique, high-impact opportunities that deviate significantly from the norm.
- **Tier 2 & 6 (Next Level):** Following the outliers, we delve into the next 15% on either side of the data spectrum. This segment helps us understand slightly less extreme but still significant deviations from the average.
- **Tier 3 & 5 (Common Ground):** We then analyze the next 15% on both sides, moving closer to the most common data points. This segment represents more typical values but is still critical for identifying broader trends and patterns.
- **Tier 4 (Core Data):** At the heart of our analysis lies the middle 20%, the largest bracket, encapsulating the core of the bell curve. This central segment is where the most common values—and often the most significant insights—reside.

By structuring our analysis in this manner, we ensure a comprehensive understanding of the entire data spectrum, from the most unusual outliers to the prevalent norms. This tiered, weighted approach enables us to pinpoint precise areas of interest, highlight potential opportunities, and ultimately guide users toward data-driven decisions that can have a tangible impact on their projects or research.

Our commitment to this analytical methodology underscores our dedication to providing not just data, but insights that can catalyze action and foster innovation across a multitude of domains.

# Social Deprivation Index (SDI) Explained

The SDI was used to calculate many of the data points for the census tract level data. This section explains how to read that data. 

## SDI Components:

- `SDI_SDI_score`: This score aggregates the various factors of social deprivation into a single metric. A lower score suggests less social deprivation, while a higher score indicates greater deprivation.

- `SDI_PovertyLT100_FPL_score`: Reflects the proportion of the population living below the Federal Poverty Level (FPL). The score represents the extent of income-based poverty in the area.

- `SDI_Single_Parent_Fam_score`: Measures the prevalence of single-parent families. A higher score can indicate more single-parent families, which may face additional social and economic challenges.

- `SDI_Education_LT12years_score`: Assesses the education levels, specifically the percentage of individuals with less than 12 years of education, implying limited schooling.

- `SDI_HHNo_Vehicle_score`: Indicates the percentage of households without access to a vehicle, which can signify transportation barriers.

- `SDI_HHRenter_Occupied_score`: Represents the ratio of renter-occupied housing units, possibly suggesting transiency or a lack of home ownership.

- `SDI_HHCrowding_score`: Looks at housing crowding, where a higher number of occupants live in a single unit than typically expected, indicating potentially overcrowded living conditions.

- `SDI_Nonemployed_score`: Measures the rate of nonemployment among the capable workforce, indicating the level of joblessness.

## SDI Percentages:

- `SDI_pct_Poverty_LT100`: The actual percentage of the population living below the Federal Poverty Level in the area.

- `SDI_pct_Single_Parent_Fam`: The percentage of families that are single-parent households.

- `SDI_pct_Education_LT12years`: The percentage of the population with less than 12 years of education.

- `SDI_pct_NonEmployed`: The percentage of the capable workforce that is not employed.

- `SDI_pctHH_No_Vehicle`: The percentage of households in the area without access to a vehicle.

- `SDI_pctHH_Renter_Occupied`: The percentage of housing units that are renter-occupied.

- `SDI_pctHH_Crowding`: The percentage of households considered overcrowded.

When interpreting the scores, they are usually standardized, often on a scale where the mean is zero, and the standard deviation is one. Thus, scores typically indicate how far and in what direction a region deviates from the mean or average level of deprivation. The actual percentages give a clearer picture of the proportion of the population affected by each factor, which can be very informative when assessing the needs of a specific area.

# Get Started using this data with QGIS

This section guides you through the process of using QGIS to visualize the included GeoJSON data layers, including adding a satellite imagery layer for enhanced mapping context. Follow these steps to effectively use the mapping tool.

## Step 1: Download and Install QGIS

QGIS is a free and open-source Geographic Information System (GIS) that allows you to create, edit, and view geographic information. To start:

- Visit the official QGIS website: [QGIS Downloads](https://www.qgis.org/en/site/forusers/download.html)
- Download the version of QGIS suitable for your operating system (Windows, macOS, or Linux).
- Follow the installation instructions provided on the site to install QGIS on your computer.

## Step 2: Load GeoJSON Files

Once QGIS is installed, you can begin loading your GeoJSON files, which contain the geographic data you wish to visualize:

- Open QGIS.
- Click on `Layer` in the top menu, then select `Add Layer` > `Add Vector Layer`.
- In the `Source` tab, click on the `...` button next to the `Vector Dataset(s)` field to browse your files.
- Select the GeoJSON file(s) you wish to load and click `Open`.
- Ensure the `File` option is selected in the `Source Type` section.
- Click `Add` and then `Close`. The GeoJSON files will automatically load and display on the map.

## Step 3: Enable Bing Satellite Images

If you do not have a satellite layer and wish to add one for better visualization, follow these steps to enable Bing satellite images in QGIS:

- First, ensure the `QuickMapServices` plugin is installed:
  - Go to `Plugins` in the top menu.
  - Select `Manage and Install Plugins...`
  - Search for `QuickMapServices` in the search bar, select it, and click `Install Plugin`.
  - Close the plugin manager once the installation is complete.
- To add the Bing satellite images:
  - Click on `Web` in the top menu, then navigate to `QuickMapServices`.
  - If you do not see Bing listed, go to `Settings` under `QuickMapServices`, click on the `More Services` tab, then `Get Contributed Pack`. Click `Save` and `OK`.
  - Now, go back to `QuickMapServices`, find `Bing` and select `Bing Maps Satellite`.
- The Bing satellite layer will now appear in your project, overlaying any loaded GeoJSON data.

![Bing Images](/_bin/images/qgis-bin_wOCFIIWW8Y.jpg)

You can easily add Google Maps imagery if you desire, but the Bing data is more consistent overall. 

## Step 4: Load Census Tract Files and Join CSV Data

This step involves loading Census Tract GeoJSON files into QGIS and joining them with the CSV data files.

### Loading Census Tract Files

- Follow the same procedure as in Step 2 to load your Census Tract files:
  - Go to `Layer` > `Add Layer` > `Add Vector Layer`.
  - Browse to select your Census Tract GeoJSON file(s) and click `Open`.
  - Click `Add` and then `Close` to see the Census Tract layers on your map.

### Joining CSV Files

The CSV files contain additional data that can be associated with the Census Tract layers. To perform the join:
  
- Ensure each CSV file is prepared with a column named `GeoID`, which corresponds to a similar ID field in the Census Tract GeoJSON data.
- Open the `Layer Properties` dialog by right-clicking on the Census Tract layer in the `Layers` panel and selecting `Properties`.
- Navigate to the `Joins` tab.
- Click the `+` button at the bottom to add a new join.
- In the `Join layer` dropdown, select the CSV file you want to join.
- For `Join field` and `Target field`, select `GeoID` or the corresponding fields that should be matched between the GeoJSON and the CSV file.
- Configure additional join options as necessary, such as choosing which columns to include in the join or handling field name conflicts.
- Click `OK` to apply the join. The attributes from the CSV file will now be appended to the attributes table of the Census Tract layer.

## Visualizing the Joined Data

This section will explain how the provided default code snippet is used in QGIS to dynamically render feature centroids with scaling based on the map scale and feature size. The map icons used for rendering are stored in the `_styles` directory, and the centroid clusters are set to a maximum display size of 80mm. This ensures that the visual representation is both informative and visually accessible across different zoom levels.

### Explanation of the Code for Feature Centroids

The code provided is used within QGIS's Expression Builder to control the size of the symbols representing the centroids of features based on the map's scale and the area of the features. Here's a breakdown of each part of the code:

```plaintext
min(
    max(
        sqrt($area) / (@map_scale / 2500) * 0.2,  -- Increased scaling factor for larger size
        12  -- Increased minimum size for better visibility when zoomed in
    ),
    60  -- Slightly increased maximum size for larger appearance when zoomed out
)
```

- **`sqrt($area)`:** This function calculates the square root of the area of the feature. Taking the square root helps in reducing the range of area values to a more manageable scale, which aids in more uniform symbol sizing.

- **`@map_scale / 2500`:** Here, `@map_scale` refers to the current map scale. Dividing this by 2500 adjusts the scale factor so that the symbol size calculation is balanced against the actual size of the map being viewed.

- **`* 0.2`:** This multiplication factor adjusts the scaling further, tuning the overall size of the centroids to ensure they are neither too large nor too small across various map scales. The value `0.2` can be adjusted based on specific visualization needs.

- **`max(..., 12)`:** The `max` function ensures that the calculated size never falls below 12mm, which helps maintain visibility when the map is zoomed in.

- **`min(..., 60)`:** Conversely, the `min` function caps the maximum size at 60mm to prevent the centroids from becoming too large when the map is zoomed out, ensuring that the map remains uncluttered and visually appealing.

### Implementing the Code in QGIS

To use this expression in QGIS:

1. **Open Layer Properties:** Right-click on the layer for which you want to set the centroid size and select `Properties`.

2. **Navigate to Symbology:** Go to the `Symbology` tab within the Layer Properties dialog.

3. **Set Size Expression:** Find the size setting for your centroid symbol and click on the expression editor button (it looks like an "ƒx" symbol). Paste the provided code into the expression editor.

4. **Save and Apply:** Confirm your settings by clicking `OK` or `Apply`. The map will now render the centroids using the sizes calculated by the expression based on the current zoom level and the area of each feature.


# 📊 Data Sources

We pride ourselves on the integrity and reliability of our data. All datasets in Miydi Maps are sourced from either official US Government agencies or reputable companies known for their high-quality data publications. Below is a list of our primary data sources:

- **United States Census Bureau**: Providing detailed demographic and socio-economic data down to the census tract level.
- **Bureau of Labor Statistics**: Offering insights into employment, labor market activity, and economic indicators at a granular geographical level.
- **National Center for Education Statistics**: Supplying educational statistics, including school district demographics and performance metrics.
- **Environmental Protection Agency**: Contributing environmental data, including pollution statistics and land use data by region.
- **Reputable Data Companies**: Partnering with leading data providers to include comprehensive datasets on consumer behavior, health statistics, and economic activities at the zip code level.

The raw datasets are included in the Raw Data Sources directory. Most can be downloaded directly from Data.gov. 

It's important to note that our repository contains the most recently released data from each source as of November 2023. However, given the varying publication frequencies (monthly, yearly, etc.) of our data sources, slight discrepancies in the timing of data releases may occur. 

## 📜 Licensing

Miydi Maps is released under the Creative Commons License. We believe in the free exchange of information and encourage you to utilize, modify, and distribute our datasets as you see fit, whether for personal projects, academic research, or commercial applications.

## 🚧 Data Limitations

While the datasets within Miydi Maps - Open Street Data edition represent the best available compilation from a vast array of official sources, it's crucial to understand that "best available" does not necessarily equate to "correct" or "accurate." The inherent limitations of our data are outlined below to ensure transparency and aid in the informed use of our resources.

### Inconsistencies and Timeframes

- **Varied Timeframes:** The datasets amalgamate information published at different intervals—ranging from monthly to every decade, with the last update in some cases as far back as 2019. This temporal disparity can lead to inconsistencies, especially in rapidly changing metrics.
- **Diverse Data Sources:** The data is compiled from a wide range of sources, each with its own reporting standards and accuracies, leading to potential discrepancies within the same layers, such as population or estimated income figures.

### COVID-19 and Recent Changes

- **Pandemic Impact:** Some datasets may not fully reflect changes brought about by the COVID-19 pandemic, which has significantly altered aspects of public life. Wherever possible, we've used the most recent values to minimize this bias.

### Data Extrapolation and Accuracy

- **Extrapolation:** To achieve granularity, some values are extrapolated from larger datasets (Zip Code, Metro, or State levels). This method means data tends to be more "accurate" at broader geographical scopes and less so at finer resolutions.
- **Uniform Demographic Weighting:** The datasets assume uniform demographic trends based on population levels across areas, which can lead to overrepresentation in less dense areas and underrepresentation in denser urban centers.

### Geographic and Reporting Limitations

- **State and Local Restrictions:** Geographic limitations, especially in areas like Massachusetts, result in underrepresented data due to local data sharing restrictions. This can significantly impact the visibility of regions such as Boston in metro-level datasets.
- **Population Double Counting:** At the census tract level, the population may be overrepresented due to potential double counting, an issue that has not been adjusted in the datasets. A more accurate representation could be achieved by cross-referencing census data with zip code level population estimates.

### Focus on Metro Areas

- **Rural Underrepresentation:** The data primarily focuses on US Major and Minor Metro Statistical areas, leading to an underrepresentation of approximately 40 million rural Americans. Assumptions based on higher-level demographic trends may overestimate values for these rural areas due to the lack of robust reporting.

Understanding these limitations is essential for effectively utilizing the datasets in Miydi Maps - Open Street Data edition. While we strive to provide the most comprehensive and up-to-date information, the nature of data compilation and the limitations of source materials mean that users should exercise caution and consider these factors when interpreting and applying the data in their projects.

