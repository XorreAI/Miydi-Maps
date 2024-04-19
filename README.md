# Welcome to Miydi Maps

Miydi Maps is an extensive repository dedicated to providing highly detailed socio-economic data, meticulously compiled down to individual census tracts and zip codes. This initiative is designed to streamline the utilization of geographic data across various advanced applications, including Artificial Intelligence, data analytics, urban planning, and more, by eliminating the complexities of data parsing.

<p align="center">
  <img src="/Miydi_Map_logo.png" alt="Miydi Maps Logo" width="400"/>
</p>

Our mission with Miydi Maps is to empower researchers, developers, and analysts by providing them with ready-to-use, granular level data that can significantly enhance the accuracy and relevance of their projects and analyses.

## 🌍 Data Granularity and Accessibility

Each dataset within Miydi Maps is structured to align with zip codes or census tracts, presenting a unique opportunity to access socio-economic data with unprecedented precision. This level of detail opens new avenues for localized research and development, offering insights that were previously challenging to obtain.

# Miydi Maps - Open Street Data 

Welcome to the Open Street Data, a dedicated repository housing GeoJson formatted data derived from Open Street Maps (OSM) specifically for the United States, with plans to extend coverage to other countries shortly. 

## 🌐 About the Data

Each file within this collection represents a single layer and "type" of OSM data, allowing for a modular approach where users can select exactly what they need for their projects. Due to GitHub's size constraints, data may be segmented into smaller, zipped files to ensure accessibility without compromising detail.

### Data Compilation and Cleaning

The data was meticulously compiled using the OSM API, pulling data for individual US regions to circumvent API limitations. This regional data was then amalgamated into comprehensive GeoJSON files. A thorough cleaning process was undertaken to eliminate duplicates, ensuring the integrity and usability of the datasets.

### Handling Extraneous Data Points

It's important to note that the original OSM API data contains a large number of extraneous data points, many of which have NULL values. These have been preserved in the datasets as they may hold value for specific projects, despite their apparent redundancy. Their presence does not significantly affect the overall size of the datasets due to their null value nature.

## 📅 Data Timeliness

The datasets currently available were pulled in April 2024. Please be aware that this data will not receive updates. However, we are considering the incorporation of additional data sets in future releases to ensure the continued relevance and expansion of the Miydi Maps - Open Street Data edition.

This edition of Miydi Maps is a testament to our commitment to providing extensive, versatile data solutions to meet the diverse needs of our users. Whether you're working on urban planning, navigation applications, or any project requiring detailed geographic data, Miydi Maps - Open Street Data edition offers the foundational data to propel your initiatives forward.

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


### 📈 Calculating Our Values: Identifying Actionable Opportunities

At Miydi Maps, our approach to data analysis is designed to unearth actionable opportunities that can drive informed decision-making and strategic planning. We employ a sophisticated weighted system, inspired by the principles of a bell curve distribution, to analyze and interpret our socio-economic datasets.

#### Bell Curve Analysis and Weighted System

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


## 📊 Data Sources

We pride ourselves on the integrity and reliability of our data. All datasets in Miydi Maps are sourced from either official US Government agencies or reputable companies known for their high-quality data publications. Below is a list of our primary data sources:

- **United States Census Bureau**: Providing detailed demographic and socio-economic data down to the census tract level.
- **Bureau of Labor Statistics**: Offering insights into employment, labor market activity, and economic indicators at a granular geographical level.
- **National Center for Education Statistics**: Supplying educational statistics, including school district demographics and performance metrics.
- **Environmental Protection Agency**: Contributing environmental data, including pollution statistics and land use data by region.
- **Reputable Data Companies**: Partnering with leading data providers to include comprehensive datasets on consumer behavior, health statistics, and economic activities at the zip code level.

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

