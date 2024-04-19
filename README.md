# Welcome to Miydi Maps

Miydi Maps is an extensive repository dedicated to providing highly detailed socio-economic data, meticulously compiled down to individual census tracts and zip codes. This initiative is designed to streamline the utilization of geographic data across various advanced applications, including Artificial Intelligence, data analytics, urban planning, and more, by eliminating the complexities of data parsing.

<p align="center">
  <img src="/Miydi_Map_logo.png" alt="Miydi Maps Logo" width="400"/>
</p>

Our mission with Miydi Maps is to empower researchers, developers, and analysts by providing them with ready-to-use, granular level data that can significantly enhance the accuracy and relevance of their projects and analyses.

## 🌍 Data Granularity and Accessibility

Each dataset within Miydi Maps is structured to align with zip codes or census tracts, presenting a unique opportunity to access socio-economic data with unprecedented precision. This level of detail opens new avenues for localized research and development, offering insights that were previously challenging to obtain.

# Miydi Maps - Open Street Data Edition

Welcome to the Open Street Data edition of Miydi Maps, a dedicated repository housing GeoJson formatted data derived from Open Street Maps (OSM) specifically for the United States, with plans to extend coverage to other countries shortly. This specialized edition is hosted on a standalone GitHub repository to accommodate the substantial file sizes and navigate GitHub's file size limitations.

## 🌐 About the Data

Each file within this collection represents a single layer and "type" of OSM data, allowing for a modular approach where users can select exactly what they need for their projects. Due to GitHub's size constraints, data may be segmented into smaller, zipped files to ensure accessibility without compromising detail.

### Data Compilation and Cleaning

The data was meticulously compiled using the OSM API, pulling data for individual US regions to circumvent API limitations. This regional data was then amalgamated into comprehensive GeoJSON files. A thorough cleaning process was undertaken to eliminate duplicates, ensuring the integrity and usability of the datasets.

### Handling Extraneous Data Points

It's important to note that the original OSM API data contains a large number of extraneous data points, many of which have NULL values. These have been preserved in the datasets as they may hold value for specific projects, despite their apparent redundancy. Their presence does not significantly affect the overall size of the datasets due to their null value nature.

## 📅 Data Timeliness

The datasets currently available were pulled in April 2024. Please be aware that this data will not receive updates. However, we are considering the incorporation of additional data sets in future releases to ensure the continued relevance and expansion of the Miydi Maps - Open Street Data edition.

This edition of Miydi Maps is a testament to our commitment to providing extensive, versatile data solutions to meet the diverse needs of our users. Whether you're working on urban planning, navigation applications, or any project requiring detailed geographic data, Miydi Maps - Open Street Data edition offers the foundational data to propel your initiatives forward.


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

## 🔄 Data Accuracy and Updates

We are committed to maintaining the highest level of accuracy in our datasets. Each dataset is subjected to rigorous quality checks and is updated in alignment with the latest releases from our data sources. This ensures that Miydi Maps remains a reliable and up-to-date resource for your needs.

We welcome contributions, suggestions, and feedback from the community to further enrich Miydi Maps. Together, we can make this repository an invaluable asset for a wide range of applications and studies.

Thank you for choosing Miydi Maps as your source for detailed socio-economic and geographic data. Let's explore the possibilities together!

