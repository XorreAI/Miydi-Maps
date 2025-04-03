# Understanding Social Deprvation Index (SDI) Data

Below is a comprehensive set of **Social Deprivation Index (SDI)**-related metrics and their detailed definitions. Each explanation is written so that non-experts and experts alike can understand the metric’s meaning, how it is calculated or adjusted, and how to interpret it in real-world contexts.

---

## Understanding SDI and Its Components

The **Social Deprivation Index (SDI)** is a composite measure designed to capture various aspects of social and economic disadvantage within a specific area (often a census tract). It combines multiple demographic indicators (such as poverty rate, education level, employment status, etc.) to produce a single score indicating the degree of deprivation. Higher SDI values typically suggest greater social disadvantage and are often correlated with negative health and economic outcomes.

In the list that follows, you’ll see references to:

- **Raw Percentages** (e.g., `SDI_pct_Poverty_LT100`): The direct fraction or percentage of the population/households that meet the specified criterion (e.g., below poverty level).
- **Sub-Scores** (e.g., `SDI_PovertyLT100_FPL_score`): Derived metrics used within the SDI framework. They incorporate raw percentages but may be weighted or scaled for comparison across different areas.
- **Adjusted Values** (`_adj` suffix): These values are recalculated relative to a larger reference area (like a zip code, county, or region). Adjusted values help interpret whether a tract’s data is high or low **within its broader local context**.
- **Metro Ratios** (`_metro_ratio` suffix): Ratios that compare the tract’s value to the **metro area average**. Ratios **above 1.0** mean the tract’s value is higher than the metro average; **below 1.0** means it is lower.
- **Flag Values** (`_natl_flag` and `_metro_flag` suffixes): Categorize the tract’s metric into **1–7 tiers**. Tiers are derived from the distribution of data (nationally or metro-wide).  
  - **Tiers 1 & 7**: Bottom 10% or top 10% (outliers)  
  - **Tiers 2 & 6**: Next 15% above and below those outliers  
  - **Tiers 3 & 5**: Next 15% above and below the center  
  - **Tier 4**: The middle 20% (the most common range)  

This tiering approach quickly shows whether a tract is unusually high or low, near the extremes, or solidly in the middle for that particular metric.

---

## 1. **`SDI_score`**
**Definition**  
- A **composite index** summarizing multiple aspects of social and economic disadvantage into a single value for each tract.  
- By combining indicators such as poverty level, education, employment, household composition, and housing conditions, it provides a holistic view of deprivation.  
- **Interpretation**:  
  - **Higher `SDI_score`** → Greater social deprivation (i.e., more concentrated poverty, lower education levels, fewer employed people, higher crowding, etc.).  
  - **Lower `SDI_score`** → Less evidence of social disadvantage relative to other tracts.

---

## 2. **`SDI_score_adj`**
**Definition**  
- This is the **adjusted** version of the overall Social Deprivation Index score.  
- It recalculates the raw composite (`SDI_score`) by **taking into account a larger reference area’s average** (e.g., zip code or county).  
- **Interpretation**:  
  - Helps determine if a tract’s overall deprivation level is higher or lower than what is typically expected in its immediate region, providing a more **locally relevant** perspective.

---

## 3. **`SDI_score_metro_ratio`**
**Definition**  
- A **ratio** comparing the tract’s `SDI_score` to the **metro area average**.  
- **Interpretation**:  
  - **> 1.0** → The tract’s SDI is higher than the metro average, indicating more deprivation.  
  - **< 1.0** → The tract’s SDI is lower than the metro average, indicating less deprivation.

---

## 4. **`SDI_score_natl_flag`**
**Definition**  
- A **1–7 tier** that places the tract’s `SDI_score` into **national** context.  
- **Interpretation**:  
  - **Tier 1** = in the bottom 10% of deprivation nationwide (least deprived).  
  - **Tier 7** = in the top 10% (most deprived).  
  - Tiers 2–6 represent gradations between these extremes, with Tier 4 typically being around the middle 20% of all tracts in the country.

---

## 5. **`SDI_score_metro_flag`**
**Definition**  
- A **1–7 tier** that classifies the tract’s `SDI_score` relative to other tracts in the **same metro area**.  
- **Interpretation**:  
  - **Tier 1** = among the least deprived tracts locally.  
  - **Tier 7** = among the most deprived tracts locally.  
  - Intermediate tiers (2–6) help identify near-outliers and more typical neighborhoods in the metro.

---

## 6. **`SDI_PovertyLT100_FPL_score`**
**Definition**  
- A **sub-score** focusing on the **percentage of individuals living below 100% of the Federal Poverty Level (FPL)**.  
- The sub-score is one component of the overall SDI.  
- **Interpretation**:  
  - A **higher sub-score** indicates **more** of the population living in poverty, which is a critical dimension of social disadvantage.

---

## 7. **`SDI_PovertyLT100_FPL_score_adj`**
**Definition**  
- The **adjusted** version of the `SDI_PovertyLT100_FPL_score`, factoring in poverty rates across a **wider area** (e.g., zip code or region).  
- **Interpretation**:  
  - Highlights whether a tract’s poverty level is significantly above or below what would be **expected in its regional context**.  

---

## 8. **`SDI_PovertyLT100_FPL_score_metro_ratio`**
**Definition**  
- A **ratio** comparing the tract’s poverty sub-score to the **metro’s** average poverty sub-score.  
- **Interpretation**:  
  - **> 1.0** → The tract has a **higher** relative poverty rate.  
  - **< 1.0** → The tract has a **lower** relative poverty rate.  

---

## 9. **`SDI_PovertyLT100_FPL_score_natl_flag`**
**Definition**  
- A **1–7 tier** comparing the tract’s poverty sub-score to **national** data.  
- **Interpretation**:  
  - **Tier 1** = among the 10% with **lowest poverty** levels in the country.  
  - **Tier 7** = among the 10% with **highest poverty** levels.  
  - Tiers 2–6 capture points in between, offering granularity.  

---

## 10. **`SDI_PovertyLT100_FPL_score_metro_flag`**
**Definition**  
- A **1–7 tier** ranking the tract’s poverty sub-score among **metro-level** data.  
- **Interpretation**:  
  - **Tier 1** = among the 10% with the **lowest** poverty rates in the metro.  
  - **Tier 7** = among the 10% with the **highest** poverty rates in the metro.  
  - Other tiers reflect intermediate ranges.

---

## 11. **`SDI_Single_Parent_Fam_score`**
**Definition**  
- A **sub-score** measuring the **prevalence of single-parent families** in a tract.  
- Often correlated with financial constraints, childcare challenges, and other socioeconomic stressors.  
- **Interpretation**:  
  - **Higher** → A greater proportion of single-parent households, signifying potentially higher need for resources (childcare, social services).

---

## 12. **`SDI_Single_Parent_Fam_score_adj`**
**Definition**  
- The **adjusted** version of the single-parent family sub-score, comparing it to the **local average**.  
- **Interpretation**:  
  - Determines if the share of single-parent families is notably high or low **within the broader region**.

---

## 13. **`SDI_Single_Parent_Fam_score_metro_ratio`**
**Definition**  
- Shows how the **single-parent family sub-score** in a tract relates to the **metro average**.  
- **Interpretation**:  
  - **> 1.0** → The tract exceeds the metro average in prevalence of single-parent households.  
  - **< 1.0** → The tract is below the metro average.

---

## 14. **`SDI_Single_Parent_Fam_score_natl_flag`**
**Definition**  
- A **1–7 tier** placing the **single-parent family sub-score** in **national** context.  
- **Interpretation**:  
  - **Tier 1** = among the bottom 10% for single-parent prevalence nationwide (very low).  
  - **Tier 7** = among the top 10% (very high).  
  - Tiers 2–6 represent shades in between.

---

## 15. **`SDI_Single_Parent_Fam_score_metro_flag`**
**Definition**  
- A **1–7 tier** placing the **single-parent family sub-score** in the context of the **metro area**.  
- **Interpretation**:  
  - **Tier 1** = among the lowest single-parent proportions in the metro.  
  - **Tier 7** = among the highest in the metro.  

---

## 16. **`SDI_Education_LT12years_score`**
**Definition**  
- A **sub-score** capturing the **percentage of adults (25+) who have completed fewer than 12 years of education** (did not finish high school).  
- Education level is a key factor influencing income potential, health outcomes, and community resources.  
- **Interpretation**:  
  - **Higher sub-score** → More adults lacking a high school diploma, indicating lower overall educational attainment.

---

## 17. **`SDI_Education_LT12years_score_adj`**
**Definition**  
- An **adjusted** version of the education sub-score, referencing the **regional average** education level.  
- **Interpretation**:  
  - Determines if the tract’s share of individuals without a high school diploma is **unusually high or low** within its broader region.

---

## 18. **`SDI_Education_LT12years_score_metro_ratio`**
**Definition**  
- A **ratio** comparing the tract’s **education sub-score** (adults with <12 years of education) to the **metro average**.  
- **Interpretation**:  
  - **> 1.0** → Lower education levels in the tract relative to the metro.  
  - **< 1.0** → Higher education levels relative to the metro.

---

## 19. **`SDI_Education_LT12years_score_natl_flag`**
**Definition**  
- A **1–7 tier** showing how the tract’s **education sub-score** compares to **national** data.  
- **Interpretation**:  
  - **Tier 1** = Among the top 10% in terms of educational attainment (i.e., fewer people without a diploma).  
  - **Tier 7** = Among the bottom 10% nationally (i.e., more people without a diploma).

---

## 20. **`SDI_Education_LT12years_score_metro_flag`**
**Definition**  
- A **1–7 tier** placing the tract’s **education sub-score** in a **metro-level** context.  
- **Interpretation**:  
  - **Tier 1** = Among the least educationally deprived areas locally.  
  - **Tier 7** = Among the most educationally deprived areas locally.

---

## 21. **`SDI_HHNo_Vehicle_score`**
**Definition**  
- A **sub-score** representing the **percentage of households lacking a personal vehicle**.  
- This is closely tied to mobility, employment opportunities, and access to healthcare or other essential services.  
- **Interpretation**:  
  - **Higher** → Indicates more households are without vehicles, suggesting potential transportation barriers.

---

## 22. **`SDI_HHNo_Vehicle_score_adj`**
**Definition**  
- The **adjusted** measure of households without vehicles, using a **broader area’s average** as a baseline.  
- **Interpretation**:  
  - Helps to see if the tract’s rate of vehicle-less households is particularly high or low **within the local region**.

---

## 23. **`SDI_HHNo_Vehicle_score_metro_ratio`**
**Definition**  
- A **ratio** comparing the tract’s no-vehicle sub-score to the **metro average**.  
- **Interpretation**:  
  - **> 1.0** → The tract has a higher share of no-vehicle households than the overall metro.  
  - **< 1.0** → The tract has a lower share than the metro average.

---

## 24. **`SDI_HHNo_Vehicle_score_natl_flag`**
**Definition**  
- A **1–7 tier** that ranks the tract’s no-vehicle sub-score **nationally**.  
- **Interpretation**:  
  - **Tier 1** = Among the bottom 10% for no-vehicle households (meaning most households do have vehicles).  
  - **Tier 7** = Among the top 10% (indicating a very high proportion of households without cars).

---

## 25. **`SDI_HHNo_Vehicle_score_metro_flag`**
**Definition**  
- A **1–7 tier** that ranks the tract’s no-vehicle sub-score **within its metro**.  
- **Interpretation**:  
  - **Tier 1** = Among the tracts with the fewest no-vehicle households locally.  
  - **Tier 7** = Among the tracts with the most no-vehicle households locally.

---

## 26. **`SDI_HHRenter_Occupied_score`**
**Definition**  
- A **sub-score** capturing the **percentage of housing units that are renter-occupied** as opposed to owner-occupied.  
- Higher renter occupancy can be associated with housing instability, lack of property-based wealth, and greater transience.  
- **Interpretation**:  
  - **Higher** → A larger share of renters, which may indicate potential social or economic vulnerabilities.

---

## 27. **`SDI_HHRenter_Occupied_score_adj`**
**Definition**  
- An **adjusted** metric that places the tract’s renter-occupied proportion in context with a **regional average**.  
- **Interpretation**:  
  - Helps identify whether the tract’s percentage of renters is **unusually high or low** within its immediate region.

---

## 28. **`SDI_HHRenter_Occupied_score_metro_ratio`**
**Definition**  
- A **ratio** of the tract’s renter-occupied sub-score relative to the **metro average**.  
- **Interpretation**:  
  - **> 1.0** → More renter-occupied housing than the typical level in the metro.  
  - **< 1.0** → Fewer renter-occupied housing units than average.

---

## 29. **`SDI_HHRenter_Occupied_score_natl_flag`**
**Definition**  
- A **1–7 tier** ranking the tract’s renter-occupied sub-score **across the nation**.  
- **Interpretation**:  
  - **Tier 1** = Among the bottom 10% for renting prevalence (mostly owner-occupied).  
  - **Tier 7** = Among the top 10% for renting prevalence.

---

## 30. **`SDI_HHRenter_Occupied_score_metro_flag`**
**Definition**  
- A **1–7 tier** ranking the tract’s renter-occupied sub-score **within the metro**.  
- **Interpretation**:  
  - **Tier 1** = Among the lowest renter occupancy in the metro.  
  - **Tier 7** = Among the highest renter occupancy in the metro.

---

## 31. **`SDI_HHCrowding_score`**
**Definition**  
- A **sub-score** measuring **household crowding**, typically defined by the **percentage of housing units with more than one person per room**.  
- Crowded homes can reflect housing affordability challenges and can be linked to health or social issues.  
- **Interpretation**:  
  - **Higher** → More households are crowded, suggesting greater housing strain.

---

## 32. **`SDI_HHCrowding_score_adj`**
**Definition**  
- The **adjusted** crowding sub-score, normalizing the raw crowding rate against a **regional average**.  
- **Interpretation**:  
  - Reveals whether a tract’s households are **particularly overcrowded or not** relative to local norms.

---

## 33. **`SDI_HHCrowding_score_metro_ratio`**
**Definition**  
- A **ratio** comparing the tract’s crowding sub-score to the **metro average**.  
- **Interpretation**:  
  - **> 1.0** → Higher crowding than the metro norm.  
  - **< 1.0** → Lower crowding than the metro norm.

---

## 34. **`SDI_HHCrowding_score_natl_flag`**
**Definition**  
- A **1–7 tier** ranking the tract’s crowding sub-score **against national data**.  
- **Interpretation**:  
  - **Tier 1** = Very low crowding (bottom 10% in the nation).  
  - **Tier 7** = Very high crowding (top 10%).  

---

## 35. **`SDI_HHCrowding_score_metro_flag`**
**Definition**  
- A **1–7 tier** comparing the tract’s crowding sub-score to other tracts **in the same metro**.  
- **Interpretation**:  
  - **Tier 1** = Among the least crowded tracts locally.  
  - **Tier 7** = Among the most crowded tracts locally.

---

## 36. **`SDI_Nonemployed_score`**
**Definition**  
- A **sub-score** indicating the **percentage of working-age adults who are not employed** (unemployed or otherwise outside the workforce, depending on data definitions).  
- Employment levels are a critical social determinant of health and well-being.  
- **Interpretation**:  
  - **Higher** → Fewer working-age adults are employed, suggesting potential economic vulnerability.

---

## 37. **`SDI_Nonemployed_score_adj`**
**Definition**  
- The **adjusted** metric for nonemployment, comparing the tract’s rate to a **regional baseline**.  
- **Interpretation**:  
  - Helps reveal if the tract’s nonemployment level is **above or below** local norms, factoring in regional economic conditions.

---

## 38. **`SDI_Nonemployed_score_metro_ratio`**
**Definition**  
- A **ratio** indicating how the tract’s nonemployment sub-score stands relative to the **metro average**.  
- **Interpretation**:  
  - **> 1.0** → Higher nonemployment (fewer people working) than typical in the metro.  
  - **< 1.0** → Lower nonemployment (more people working) than the metro average.

---

## 39. **`SDI_Nonemployed_score_natl_flag`**
**Definition**  
- A **1–7 tier** placing the tract’s nonemployment sub-score in **national** context.  
- **Interpretation**:  
  - **Tier 1** = Among the 10% with **lowest** nonemployment rates (most people working).  
  - **Tier 7** = Among the 10% with the **highest** nonemployment rates.

---

## 40. **`SDI_Nonemployed_score_metro_flag`**
**Definition**  
- A **1–7 tier** placing the tract’s nonemployment sub-score in **metro** context.  
- **Interpretation**:  
  - **Tier 1** = Among the metro’s lowest nonemployment rates.  
  - **Tier 7** = Among the metro’s highest.

---

## 41. **`SDI_sdi`**
**Definition**  
- Another representation of the **overall Social Deprivation Index** (similar to `SDI_score`).  
- Often included for consistency across different data sources or different naming conventions.  
- **Interpretation**:  
  - **Higher** → More combined indicators of social disadvantage.  
  - **Lower** → Fewer indicators of social disadvantage.

---

## 42. **`SDI_sdi_adj`**
**Definition**  
- The **adjusted** form of the **overall SDI**, factoring in a **regional average**.  
- **Interpretation**:  
  - Indicates how this tract’s overall social disadvantage compares to local norms.  
  - May differ slightly from the unadjusted `SDI_sdi`, offering more localized insight.

---

## 43. **`SDI_pct_Poverty_LT100`**
**Definition**  
- The **raw percentage** of individuals in the tract living **below 100% of the Federal Poverty Level** (FPL).  
- **Interpretation**:  
  - Direct measure of how many residents fall under the poverty threshold, which is crucial for understanding local economic conditions.  

---

## 44. **`SDI_pct_Poverty_LT100_adj`**
**Definition**  
- The **adjusted** version of the **raw percentage** of residents living below the FPL, taking into account a **larger area’s** poverty rates.  
- **Interpretation**:  
  - Helps isolate whether the tract’s poverty level is **unusually high or low** compared to the region’s typical poverty rate.

---

## 45. **`SDI_pct_Single_Parent_Fam`**
**Definition**  
- The **raw percentage** of families in the tract that are headed by a **single parent**.  
- **Interpretation**:  
  - Single-parent families may have unique economic challenges, and higher percentages can indicate increased need for targeted support (childcare, after-school programs, etc.).

---

## 46. **`SDI_pct_Single_Parent_Fam_adj`**
**Definition**  
- The **adjusted** single-parent family percentage, referencing a broader geographic average.  
- **Interpretation**:  
  - Shows how the tract’s single-parent family rate stacks up locally, rather than just comparing to a national baseline.

---

## 47. **`SDI_pct_Education_LT12years`**
**Definition**  
- The **raw percentage** of adults aged 25+ in the tract who have **not completed high school** (fewer than 12 years of education).  
- **Interpretation**:  
  - Gives a direct snapshot of educational attainment.  
  - Higher percentages can signal potential barriers to employment, lower average incomes, and increased social support needs.

---

## 48. **`SDI_pct_Education_LT12years_adj`**
**Definition**  
- The **adjusted** rate of adults with fewer than 12 years of education.  
- **Interpretation**:  
  - Allows a better understanding of how the tract compares to local education patterns, controlling for regional norms.

---

## 49. **`SDI_pct_NonEmployed`**
**Definition**  
- The **raw percentage** of working-age adults who are **not employed** in the tract.  
- This typically includes the unemployed, but might also include those not in the labor force for various reasons (depending on data definitions).  
- **Interpretation**:  
  - The higher the percentage, the fewer people are actively working, which can have implications for community income levels and economic stability.

---

## 50. **`SDI_pct_NonEmployed_adj`**
**Definition**  
- The **adjusted** percentage of nonemployed adults, relative to a **local average**.  
- **Interpretation**:  
  - Highlights if the tract’s nonemployment rate stands out locally, helping policymakers see if an area may need additional job training or support programs.

---

## 51. **`SDI_pctHH_No_Vehicle`**
**Definition**  
- The **raw percentage** of households lacking a **personal vehicle**.  
- **Interpretation**:  
  - Indicates the direct share of households that may rely on public transit or other forms of transportation, which could affect access to jobs, healthcare, and education.

---

## 52. **`SDI_pctHH_No_Vehicle_adj`**
**Definition**  
- The **adjusted** figure for households without a vehicle, taking into account the **broader area’s** average.  
- **Interpretation**:  
  - Determines if this tract is notably car-deficient (or car-heavy) **compared to neighboring areas**.

---

## 53. **`SDI_pctHH_Renter_Occupied`**
**Definition**  
- The **raw percentage** of housing units that are **renter-occupied**.  
- **Interpretation**:  
  - Offers a direct look at how many people rent vs. own in the tract. High renting can imply greater population turnover and potentially lower overall household wealth.

---

## 54. **`SDI_pctHH_Renter_Occupied_adj`**
**Definition**  
- The **adjusted** renter-occupied housing percentage, **normalized** against a broader geographic average.  
- **Interpretation**:  
  - Helps confirm if this tract stands out compared to nearby areas for its rate of renter occupancy.

---

## 55. **`SDI_pctHH_Crowding`**
**Definition**  
- The **raw percentage** of households considered **overcrowded**, usually more than one occupant per room.  
- **Interpretation**:  
  - A key indicator of housing stress, correlated with health and social challenges.  
  - Higher values indicate more crowding.

---

## 56. **`SDI_pctHH_Crowding_adj`**
**Definition**  
- The **adjusted** overcrowding rate, using **regional** data as a reference.  
- **Interpretation**:  
  - Clarifies whether a tract’s overcrowding level is notably high or low **within its local context** rather than just in a national vacuum.

---



